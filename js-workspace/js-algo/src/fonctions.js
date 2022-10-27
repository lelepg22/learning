/* 
fonctions.js : Introduction aux fonctions
2022-10-27
*/

function addition(operande1,operande2) {

   console.log("operande1 = " + operande1 + " operande2 = " + operande2 );
   console.log(" addition : " + operande1 + " + " + operande2 + " = " + (operande1 + operande2));
   return operande1 + operande2;
     
}

function division(operande1, operande2){
    if((operande1 == 0 || operande2 == 0)){
        throw new Error("Opération illégale! " + operande1 + " / " + operande2 );
    }
    
    console.log("operande1 = " + operande1 + " operande2 = " + operande2 );
    console.log(" division : " + operande1 + " / " + operande2 + " = " + (operande1 / operande2));
    return operande1 / operande2;
}

let result = 0;
let somme = addition(4,4);
let divise = division(10,2);
let autreSomme = addition(addition(10,9), addition(2,2));

addition(4,2);
division(10,2);

console.log(somme);
console.log(autreSomme);


const tablo = [15,12,8,3,2];

tablo.map(x=> result = addition(x,result));
console.log(result + " total");



console.log(divise);

try {
    division(2,10)
} catch(error){
    console.log(error)
}







