function entradaCuenta() {
    var bc=prompt("Introduzca el numero de Banco");
    var sc=prompt("Introduzca el numero de Sucursal");
    var c=prompt("Introduzca el numero de Cuenta");

    if((bc.length<=4)&&(sc.length<=4)&&(c.length<=10)){

                alert(codigosControl(bc,sc,c));
            }else{
        alert("Valores introducidos erroneos, han de ser numeros" +
            " 4 para el banco" +
            " 4 para la sucursal" +
            " 10 para la cuenta");
    }



}
function entradaCalculoIban() {
    var cuenta=prompt("Introduzca el numero de Cuenta");
    if(cuenta.length==20){
      alert(calculoIBANEspanya(cuenta));
    }else{
        alert("Valor introducido erroneo, a de" +
            " ser una cuenta con 20 digitos");
    }


}
function entradaControlIban() {
    var iban=prompt("Introduzca el Iban");
    if(iban.length<=31){
        if(comprobarIBAN(iban)){
            alert("El IBAN es correcto");
        }else{
            alert("El IBAN es incorrecto");
        }
    }else{
        alert("Valor introducido erroneo, a de" +
            " ser una cuenta con 20 digitos");
    }


}