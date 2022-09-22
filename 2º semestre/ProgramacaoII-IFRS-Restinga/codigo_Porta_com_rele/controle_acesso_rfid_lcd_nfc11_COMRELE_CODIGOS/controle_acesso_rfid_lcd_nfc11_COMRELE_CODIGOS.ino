#include <SPI.h>//include the SPI bus library
#include <MFRC522.h>//include the RFID reader library
#include <LiquidCrystal.h>


// VVVVVVVVVVVVVVVV buzzer musical VVVVVVVVVVVVVVV
#define NOTE_B0  31
#define NOTE_C1  33
#define NOTE_CS1 35
#define NOTE_D1  37
#define NOTE_DS1 39
#define NOTE_E1  41
#define NOTE_F1  44
#define NOTE_FS1 46
#define NOTE_G1  49
#define NOTE_GS1 52
#define NOTE_A1  55
#define NOTE_AS1 58
#define NOTE_B1  62
#define NOTE_C2  65
#define NOTE_CS2 69
#define NOTE_D2  73
#define NOTE_DS2 78
#define NOTE_E2  82
#define NOTE_F2  87
#define NOTE_FS2 93
#define NOTE_G2  98
#define NOTE_GS2 104
#define NOTE_A2  110
#define NOTE_AS2 117
#define NOTE_B2  123
#define NOTE_C3  131
#define NOTE_CS3 139
#define NOTE_D3  147
#define NOTE_DS3 156
#define NOTE_E3  165
#define NOTE_F3  175
#define NOTE_FS3 185
#define NOTE_G3  196
#define NOTE_GS3 208
#define NOTE_A3  220
#define NOTE_AS3 233
#define NOTE_B3  247
#define NOTE_C4  262
#define NOTE_CS4 277
#define NOTE_D4  294
#define NOTE_DS4 311
#define NOTE_E4  330
#define NOTE_F4  349
#define NOTE_FS4 370
#define NOTE_G4  392
#define NOTE_GS4 415
#define NOTE_A4  440
#define NOTE_AS4 466
#define NOTE_B4  494
#define NOTE_C5  523
#define NOTE_CS5 554
#define NOTE_D5  587
#define NOTE_DS5 622
#define NOTE_E5  659
#define NOTE_F5  698
#define NOTE_FS5 740
#define NOTE_G5  784
#define NOTE_GS5 831
#define NOTE_A5  880
#define NOTE_AS5 932
#define NOTE_B5  988
#define NOTE_C6  1047
#define NOTE_CS6 1109
#define NOTE_D6  1175
#define NOTE_DS6 1245
#define NOTE_E6  1319
#define NOTE_F6  1397
#define NOTE_FS6 1480
#define NOTE_G6  1568
#define NOTE_GS6 1661
#define NOTE_A6  1760
#define NOTE_AS6 1865
#define NOTE_B6  1976
#define NOTE_C7  2093
#define NOTE_CS7 2217
#define NOTE_D7  2349
#define NOTE_DS7 2489
#define NOTE_E7  2637
#define NOTE_F7  2794
#define NOTE_FS7 2960
#define NOTE_G7  3136
#define NOTE_GS7 3322
#define NOTE_A7  3520
#define NOTE_AS7 3729
#define NOTE_B7  3951
#define NOTE_C8  4186
#define NOTE_CS8 4435
#define NOTE_D8  4699
#define NOTE_DS8 4978
#define REST      0


// change this to make the song slower or faster
int tempo = 225;
// change this to whichever pin you want to use
int buzzer = A5;


//VVVVVVVVVVVVVVVVVVVV  goo goo song VVVVVVVVVVVVVVVVVVVV
const int googoo[] PROGMEM= {
  // At Doom's Gate (E1M1)
  // Score available at https://musescore.com/pieridot/doom

  NOTE_E2, 8, NOTE_E2, 8, NOTE_E3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_D3, 8, NOTE_E2, 8, NOTE_E2, 8, //1
  NOTE_C3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_AS2, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_B2, 8, NOTE_C3, 8,
  NOTE_E2, 8, NOTE_E2, 8, NOTE_E3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_D3, 8, NOTE_E2, 8, NOTE_E2, 8,
  NOTE_C3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_AS2, -2,

  NOTE_E2, 8, NOTE_E2, 8, NOTE_E3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_D3, 8, NOTE_E2, 8, NOTE_E2, 8, //9
  NOTE_C3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_AS2, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_B2, 8, NOTE_C3, 8,
  NOTE_E2, 8, NOTE_E2, 8, NOTE_E3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_D3, 8, NOTE_E2, 8, NOTE_E2, 8,
  NOTE_C3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_AS2, -2,

  NOTE_E2, 8, NOTE_E2, 8, NOTE_E3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_D3, 8, NOTE_E2, 8, NOTE_E2, 8, //13
  NOTE_C3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_AS2, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_B2, 8, NOTE_C3, 8,
  NOTE_E2, 8, NOTE_E2, 8, NOTE_E3, 8, NOTE_E2, 8, NOTE_E2, 8, NOTE_D3, 8, NOTE_E2, 8, NOTE_E2, 8,
  NOTE_FS3, -16, NOTE_D3, -16, NOTE_B2, -16, NOTE_A3, -16, NOTE_FS3, -16, NOTE_B2, -16, NOTE_D3, -16, NOTE_FS3, -16, NOTE_A3, -16, NOTE_FS3, -16, NOTE_D3, -16, NOTE_B2, -16,



 
};

// sizeof gives the number of bytes, each int value is composed of two bytes (16 bits)
// there are two values per note (pitch and duration), so for each note there are four bytes
int notes = sizeof(googoo) / sizeof(googoo[0]) / 2;

// this calculates the duration of a whole note in ms
int wholenote = (60000 * 4) / tempo;

int divider = 0, noteDuration = 0;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

// ^^^^^^^^^^^^^^^^^^^^ buzzer musical ^^^^^^^^^^^^^^^^^^^^^^


#define SS_PIN 10  //slave select pin
#define RST_PIN 9  //reset pin
#define RELE 8     //pino do rele
MFRC522 mfrc522(SS_PIN, RST_PIN);        // instatiate a MFRC522 reader object.
MFRC522::MIFARE_Key key;//create a MIFARE_Key struct named 'key', which will hold the card information
LiquidCrystal lcd(6, 7, 5, 4, 3, 2);   // pinos referentes do lcd (rs, enable, d4, d5, d6, d7)
char st[20];
#define NUM_CARTOES 17

void setup() {
        pinMode(RELE, OUTPUT);
        digitalWrite(RELE,HIGH);
        Serial.begin(9600);        // Initialize serial communications with the PC
        SPI.begin();               // Init SPI bus
        mfrc522.PCD_Init();        // Init MFRC522 card (in case you wonder what PCD means: proximity coupling device)
        Serial.println("Scan a MIFARE Classic card");
        //Define o número de colunas e linhas do LCD:  
        lcd.begin(16, 2);      
        lcd.print((char) 223);

        for (byte i = 0; i < 6; i++) {
                key.keyByte[i] = 0xFF;//keyByte is defined in the "MIFARE_Key" 'struct' definition in the .h file of the library
        }
      mensageminicial();
}

int block=2;//this is the block number we will write into and then read. Do not write into 'sector trailer' block, since this can make the block unusable.
                          
byte blockcontent[16] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//all zeros. This can be used to delete a block.
byte readbackblock[18];//This array is used for reading out a block. The MIFARE_Read method requires a buffer that is at least 18 bytes to hold the 16 bytes of a block.
byte acesso_nomes[NUM_CARTOES][16] ={
                    "Rafael Esteves", //0
                    "Regio Michelin", //1
                    "Roben Lunardi", //2
                    "Rodrigo Lange", //3
                    "Teste",
                    "Denner Rocha",
                    "Laura",
                    " Vitoria",
                    " Jonas",
                    " Nicolas",
                    " Manoeal",
                    " Gabriel Portal",
                    " Levy" ,
                    " Renato",
                    " Gleison", 
                    "goo goo", //15
                    "Igor BF" //16
               
                  };
byte acesso_senhas[NUM_CARTOES][16] ={
                    "Rafael Esteves", //0
                    "Regio Michelin", //1
                    "patasdegalinha", //2
                    "Rodrigo Lange", //3
                    "Teste",
                    "Denner Rocha",
                    "Laura",
                    " Vitoria",
                    " Jonas",
                    " Nicolas",
                    " Manoeal",
                    " Gabriel Portal",
                    " Levy" ,
                    " Renato",
                    " Gleison",
                    "goo goo", //15
                    "Igor BF" //16
              
                  };
                  
byte nome[18]; // nome a ser lido pelo cartao
byte senha[18];
int estado_leitura;

void loop()
{
    char nomeLido[20]; 
        /*****************************************establishing contact with a tag/card**********************************************************************/
        
	if ( ! mfrc522.PICC_IsNewCardPresent()) {//if PICC_IsNewCardPresent returns 1, a new card has been found and we continue
		return;//if it did not find a new card is returns a '0' and we return to the start of the loop
	}

	if ( ! mfrc522.PICC_ReadCardSerial()) {//if PICC_ReadCardSerial returns 1, the "uid" struct (see MFRC522.h lines 238-45)) contains the ID of the read card.
		return;//if it returns a '0' something went wrong and we return to the start of the loop
	}
  mensageminicial();
         
       
         Serial.println("card selected");
         
         /*****************************************writing and reading a block on the card**********************************************************************/
         
         nome[0]='@';
         block=2;
         estado_leitura=readBlock(block,nome);
         if(estado_leitura==3 || estado_leitura==4){
           mensageminicial();
           mfrc522.PCD_Init();
         }
         Serial.print("nome: ");
  
          
         senha[0]='!';
         block=4;
         estado_leitura=readBlock(block,senha);
         Serial.print("senha: ");

         if(estado_leitura==3 || estado_leitura==4){
           mensageminicial();
           mfrc522.PCD_Init();
         }
         lcd.clear();
         lcd.setCursor(0,0);
         lcd.print("Lendo....");
         delay(500);
         
         if (liberaPassagem(nome,senha)){
           Serial.println(" FOI");
           lcd.setCursor(0,1);
           lcd.print("ACESSO LIBERADO");
           delay(1000);

          sprintf(nomeLido, "%s", nome);    // converter para string
          
          lcd.clear();
          lcd.setCursor(0,0);
          lcd.print("Seja bem vindo ao");
          lcd.setCursor(0, 1);
          lcd.print("Lab de Robotica!");
          delay(1000);
          
          lcd.clear();
          lcd.setCursor(0, 0);
          lcd.print(nomeLido);
 
           digitalWrite(RELE,LOW);    // aciona o rele
           delay(2000);
           digitalWrite(RELE,HIGH);
           delay(200);
            googooSong();
         }else{
           lcd.setCursor(0,1);
           lcd.print("ACESSO NEGADO");
          // digitalWrite(RELE,HIGH);
           delay(2000);
         }
         mensageminicial();
         mfrc522.PCD_Init();
         //digitalWrite(RELE,HIGH);
         delay(20);
 
}

int writeBlock(int blockNumber, byte arrayAddress[]) 
{
  //this makes sure that we only write into data blocks. Every 4th block is a trailer block for the access/security info.
  int largestModulo4Number=blockNumber/4*4;
  int trailerBlock=largestModulo4Number+3;//determine trailer block for the sector
  if (blockNumber > 2 && (blockNumber+1)%4 == 0){Serial.print(blockNumber);Serial.println(" is a trailer block:");return 2;}//block number is a trailer block (modulo 4); quit and send error code 2
  Serial.print(blockNumber);
  Serial.println(" is a data block:");
  
  /*****************************************authentication of the desired block for access***********************************************************/
  byte status = mfrc522.PCD_Authenticate(MFRC522::PICC_CMD_MF_AUTH_KEY_A, trailerBlock, &key, &(mfrc522.uid));
  if (status != MFRC522::STATUS_OK) {
         Serial.print("PCD_Authenticate() failed: ");
         Serial.println(mfrc522.GetStatusCodeName(status));
         return 3;//return "3" as error message
  }
         
  status = mfrc522.MIFARE_Write(blockNumber, arrayAddress, 16);//valueBlockA is the block number, MIFARE_Write(block number (0-15), byte array containing 16 values, number of bytes in block (=16))
  //status = mfrc522.MIFARE_Write(9, value1Block, 16);
  if (status != MFRC522::STATUS_OK) {
           Serial.print("MIFARE_Write() failed: ");
           Serial.println(mfrc522.GetStatusCodeName(status));
           return 4;//return "4" as error message
  }
  Serial.println("block was written");
}


int readBlock(int blockNumber, byte arrayAddress[]) 
{
  int largestModulo4Number=blockNumber/4*4;
  int trailerBlock=largestModulo4Number+3;//determine trailer block for the sector

  /*****************************************authentication of the desired block for access***********************************************************/
  byte status = mfrc522.PCD_Authenticate(MFRC522::PICC_CMD_MF_AUTH_KEY_A, trailerBlock, &key, &(mfrc522.uid));
  if (status != MFRC522::STATUS_OK) {
         Serial.print("PCD_Authenticate() failed (read): ");
         Serial.println(mfrc522.GetStatusCodeName(status));
         return 3;//return "3" as error message
  }
      
  byte buffersize = 18;//we need to define a variable with the read buffer size, since the MIFARE_Read method below needs a pointer to the variable that contains the size... 
  status = mfrc522.MIFARE_Read(blockNumber, arrayAddress, &buffersize);//&buffersize is a pointer to the buffersize variable; MIFARE_Read requires a pointer instead of just a number
  if (status != MFRC522::STATUS_OK) {
          Serial.print("MIFARE_read() failed: ");
          Serial.println(mfrc522.GetStatusCodeName(status));
          return 4;//return "4" as error message
  }
  Serial.println("block was read");
  
  
}
void mensageminicial(){
  lcd.clear();
  lcd.print(" Aproxime o seu");  
  lcd.setCursor(0,1);
  lcd.print("cartao do leitor");  
}

boolean liberaPassagem(byte nome[],byte senha[]){
  
  for (int i=0 ; i<NUM_CARTOES ; i++){
    for (int j=0; j<16; j++){
      //caso nome ou senha da linha i for diferente break e vai pra proxima
      if (acesso_nomes[i][j]!=nome[j] || acesso_senhas[i][j]!=senha[j]){ 
        break;
      }
      if (j==15){
        return true; //se todos os caracteres sao iguais, retorna true
      }
    }
  }
  return false;
}

void googooSong(){
  // iterate over the notes of the melody.
  // Remember, the array is twice the number of notes (notes + durations)
  for (int thisNote = 0; thisNote < notes * 2; thisNote = thisNote + 2) {

    // calculates the duration of each note
    divider = pgm_read_word_near(googoo+thisNote + 1);
    if (divider > 0) {
      // regular note, just proceed
      noteDuration = (wholenote) / divider;
    } else if (divider < 0) {
      // dotted notes are represented with negative durations!!
      noteDuration = (wholenote) / abs(divider);
      noteDuration *= 1.5; // increases the duration in half for dotted notes
    }

    // we only play the note for 90% of the duration, leaving 10% as a pause
    tone(buzzer, pgm_read_word_near(googoo+thisNote), noteDuration * 0.9);

    // Wait for the specief duration before playing the next note.
    delay(noteDuration);

    // stop the waveform generation before the next note.
    noTone(buzzer);
  }
}
