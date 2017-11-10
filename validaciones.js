var codbanco;
var sucursal;
var numcuenta;
var codcuenta;
var IBAN;

function codigosControl(codbanco,sucursal,numcuenta) {
	var numero1;
	var numero2;
	var suma;
	var numero3;
	var codControl;
	var total;
	//codigo banco
	numero1=codbanco.charAt(0)*4;
	numero1+=codbanco.charAt(1)*8;
	numero1+=codbanco.charAt(2)*5;
	numero1+=codbanco.charAt(3)*10;
	//codigo sucursal
	numero2=sucursal.charAt(0)*9;
	numero2+=sucursal.charAt(1)*7;
	numero2+=sucursal.charAt(2)*3;
	numero2+=sucursal.charAt(3)*6;
	//suma
	total=numero1+numero2;
	//calcular 
	total=total%11;
	total=11-total;

	//calculamos los dos digitos
	if(total<10){
		div2.toString();
	}else if(total==10){
		div2=1;
	}else{
		div2=0;
	}
	//cifras numero de cuenta
	numero3=numcuenta.charAt(0)*1;
	numero3+=numcuenta.charAt(1)*2;
	numero3+=numcuenta.charAt(2)*4;
	numero3+=numcuenta.charAt(3)*8;
	numero3+=numcuenta.charAt(4)*5;
	numero3+=numcuenta.charAt(5)*10;
	numero3+=numcuenta.charAt(6)*9;
	numero3+=numcuenta.charAt(7)*7;
	numero3+=numcuenta.charAt(8)*3;
	numero3+=numcuenta.charAt(9)*6;
	//calculamos caracter de control
	numero3=numero3%11;
	numero3=11-numero3;

	if(numero3<10){
		numero3.toString();
	}else if(numero3==10){
		div4=1;
	}else{
		div4=0;
	}
	//conseguimos los dos digitos del caracter de control
	codControl=total+numero3;
	return codControl;




}

function calculoIBANEspanya(codcuenta) {
	//pasamos a string el codigo de la cuenta (20 digitos)
	var nuevo=codcuenta.toString();
	//añadimos el prefijo de españa ES 
	nuevo=codcuenta.concat("ES00");
	//calculamos el codigo de control del IBAN
	//División entre 97 por ser un numero demasiado grande

        var resto=0;

        for (var i=0; i<nuevo.length; i+=10) {

            var dividendo = resto + "" + x.substr(i, 10);

            resto = dividendo % 97;

        }



        var modulo=98-resto;

        var modulo=modulo.toString();

        var control;

        if (modulo.length==2){

            control=modulo;


        }else if (modulo < 10){

            modulo=modulo.toString();

            control="0"+modulo;

            alert(control);

        }

        var iban = "ES"+control+" "+cuenta;

        return iban;

    }
}

function comprobarIBAN(IBAN) {
	var estado=false;
	var nuevo=IBAN.toString();
	//cogemos los 4 primeros digitos
	var cadena=nuevo.substring(0,4);
	//siguientes digitos
	var cadena2= nuevo.substring(4);
	//convertimos las letras en numeros con un array
	var letras=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U",
        "V","W","X","Y","Z"];
    //asignamos el valor de cada pais 
    var paises= [ ["DE",22],["BE",16],["CY",28],["DK",18],["SI",19],["EE",20],["FR",27],["HU",28],["IT",27],
        ["LT",20],["MT",31],["PL",28],["GB",22],["RO",24],["IS",26],["CH",21],["MC",27],["AT",20],
        ["BG",22],["HR",21],["SK",24],["ES",24],["FI",18],["GR",27],["IE",22],["LV",21],["LU",20],
        ["NL",18],["PT",25],["CZ",24],["SE",24],["NO",15],["SM",27],["LI",21]];

	//cambiado el IBAN al final
	var cuenta=cadena2+cadena;
	var nueva=cuenta%97;
	//si esta correcto el cociente en 1
	if(nueva==1){
		return true;
	}else{
		return false;
	}

	


}


