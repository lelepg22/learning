/*
algo.js: Initiation algorithmique avec JS
2022-10-26
*/


// Set a variable in JS

let myName ;
myName = 'Bond';

// Sets a constant in JS

const myConstant = 'James';

// Display myConstant content

console.log(myConstant) ;  // console.log() <=> write();  // <=> Equivalence **


let firstNumber = 1 ;
let secondNumber = firstNumber * 3 ;

//Concaténation + entre chaîne et n'importe quel autre type
firstNumber = 5 ; 

secondNumber = firstNumber * 3 ;

console.log('First Number: ' + firstNumber + ' Second Number : ' + secondNumber) ;


//Boolean
// Si secondNumber <= 10 ALORS isOlderThan prend la valeur FAUX

// SINON isOlderThan prend la valeur vrai

                                //  (cas positif) : (cas negatif)
let isOlderThan = (secondNumber <= 10) ? false : true;

let isYoungerThan = secondNumber <= 10;

//Condition
if (isOlderThan == isYoungerThan) {
    //Do if true
    console.log('Je suis plus vieux') ;     
}
else{
     //Do if false
     console.log('Je suis plus jeune') ; 
}
if(secondNumber >= 10) {
    isOlderThan = true
}
else{    
    isOlderThan = false;
}






/*

class Test{
    testA;
    testB;
    test(x){
        this.testA = x;
        this.testB = this.testA * 3;
        console.log(this.testB);

    }
}
b = new Test();
b.test(2);


*/











