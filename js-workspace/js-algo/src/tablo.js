/* 
    tablo.js: Structures plus complexes
    2022-10-26
*/



const monTablo = [10, 3, 12 , 15, 18];

const valeur =  monTablo[2]; // Accède à valeur 1é du tableau


monTablo.push(20); 

itemNumber = monTablo.length;

monTablo[6] = 30;


console.log(... monTablo);

// for(let indice = 0 ; indice < monTablo.length; indice = indice + 1){
//     console.log(monTablo[indice]);
// }

// for(let indice = 0 ; indice < monTablo.length; indice = indice + 1){
//     if(monTablo[indice] % 2 == 0){    
//     console.log(monTablo[indice]);
//     }
// }

// // OR

// for(let number of monTablo){
//     if(number % 2 == 0){
//         console.log('Pair : ' + number)
//     }
// }

// Calculer la somme des valeurs du tableau
// Afficher cette somme
let result = 0;
let result2 = 0;
let result3 = 0;

// for(let number of monTablo){
//     if(number % 2 == 0){
//         result2 = result2 + number;
//         console.log('Pair Somme :' + result2)
//     }
// }

// for(let number of monTablo){
//   result = result + number;  
//     console.log(result);  

// }


// for(let indice = 0 ; indice < monTablo.length; indice = indice + 1){
//     result = result + monTablo[indice];

//     if(indice == (monTablo.length - 1)){    
//         console.log(result);
//     }

// }


// Chercher et afficher la plus grande valeur du tableau
// ansi que l'indice de cette valeur

result = monTablo[0];
result2 = 0;

for(let indice = 0 ; indice < monTablo.length; indice = indice + 1){

    if(monTablo[indice] > result ){
        result = monTablo[indice];
        result2 = indice;
        
    }
  

}
console.log("Number : " + result, "Indice : " + result2);

// Chercher et afficher la plus petit valeur du tableau
// ansi que l'indice de cette valeur

result3 = monTablo[0];
result2 = 0;

for(let indice = 0 ; indice < monTablo.length; indice = indice + 1){
    if(monTablo[indice] < result3 ){
        result3 = monTablo[indice];
        result2 = indice;
    }
}
console.log("NumberMin : " + result3, "Indice : " + result2);

let persons = [ 
    ['Jean', 54],
    ['Paul', 23],
    ['Virginie', 35],
    ['Delphine', 26]
];


let name = "";
let age = 0;
let moyenAge = 0;
let moinAge = -1;
let moinAgePrenom = "";

for(let person of persons){

    for(let each of person){
        if(typeof each == typeof name){
            name = each;
        }
        else{
            age = each;
        }

    }

    //Initialization AGE et NAME   
    if(moinAge == -1){
        moinAge = age;
        moinAgePrenom = name;
    }

    //Comparation AGE
    else if(moinAge > age){
        moinAge = age;
        moinAgePrenom = name;

    }

    console.log("Nom : " + name + " | Age : " + age );

    moyenAge = moyenAge + age;

}

console.log(moyenAge / persons.length);
console.log("Moins Age / Name : => " + moinAge + " / " + moinAgePrenom )

let youngerAge = persons[0][1];
let youngerName = "";

persons.map( x=> {
    if(x[1] <= moinAge){
        youngerAge = x[1]
        youngerName = x[0];                
    } 
    
    persons = [youngerName, youngerAge];
   
} );
return console.log(persons);
// moinAge = persons[0][1]
// console.log(persons.filter( x=> x[1] <= moinAge));

