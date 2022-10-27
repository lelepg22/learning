/* while.js : Boucle conditionnelle
2022 - 10 - 27

TANT QUE(condition) FAIRE
Votre code ici
FIN TANT QUE
*/

let occurrences = 0;

while (occurrences < 9) {
    console.log('Occurrence : ' + occurrences);
    occurrences = occurrences + 1;
};

const tablo = [5,12,8,9,7];
let index = 0;
let result = 0;

function isOdd(params){
    return params % 2 != 0;  // return true or false
}

while(index < tablo.length){

    if(isOdd(tablo[index])){
        result = result + tablo[index];
    }
    index = index + 1;

}
console.log(result);