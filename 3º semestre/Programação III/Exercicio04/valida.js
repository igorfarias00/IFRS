// Exercicio feito por Igor Balest Farias 
// para cadeira de Programação III

function validarForm() {
    var nome = document.getElementById('nome');
    var cpf = document.getElementById('cpf');
    var nascimento = document.getElementById('nascimento');
    var peso = document.getElementById('peso');
    var altura = document.getElementById('altura');
    var genero;
    
    if(document.getElementById('masculino').checked){
        genero = 'masculino';
    } else if (document.getElementById('feminino').checked){
        genero = 'feminino';
    } else {
        genero = 'naoMarcou';
    }
    
    var dia = nascimento.value.slice(0,2);
    var mes = nascimento.value.slice(3,5);
    var ano = nascimento.value.slice(6,11);                


    if(peso != '' && altura.value != '' && genero != 'naoMarcou'){
        if( !isNaN(cpf.value) ){ 
            if(!isNaN(altura.value) && !isNaN(peso.value)){
                if((dia >= 1 && dia <= 31) && (mes >=1 && mes <= 12) && (!isNaN(ano))){
                    alert('FOI');
                    return true

                } else {
                    alert('Data não está no formato dd/mm/aaaa');
                    return false
                }
            } else {
                alert('Peso e altura precisam ser numeros');
                return false
            }
        } else {
            alert('CPF precisa ser somente numeros');
            return false
           
        }
    } else {
        alert('Peso, altura e Genero são campos obrigatorios');
        return false
    }

    

   
}