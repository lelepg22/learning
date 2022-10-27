const alphabet = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","x","z"];
const chiffre = [0,1,2,3,4,5,6,8,9];
const charEspecial = ["`", "!", ",", "?", "^","~"];


let minMajuscule = 0;
let minChiffre = 0;
let minSigne = 0;
let mdp = "";

function getRandomArbitrary(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
  } 

function randomPassword(){
    let indice = 0;
    let passCount = getRandomArbitrary(8,17);
   
   while(indice < passCount){

        let random = Math.floor(Math.random() * (3 - 0) + 0);
        let lettre = "";

        if(random == 0){
            lettre = alphabet[Math.floor(Math.random() * ((alphabet.length - 1) - 0) + 0)];

            if(Math.round(Math.random()) > 0){
                lettre = lettre.toUpperCase();
                minMajuscule = minMajuscule + 1;
            }

            mdp = mdp + lettre;

        }
        if(random == 1){
            mdp = mdp + chiffre[Math.floor(Math.random() * ((chiffre.length - 1) - 0) + 0)]; 
            minChiffre = minChiffre + 1;       
        }

        if(random == 2){
            mdp = mdp + charEspecial[Math.floor(Math.random() * ((charEspecial.length - 1) - 0) + 0)];
            minSigne = minSigne + 1; 
        }

        indice = indice + 1;
    }
   console.log("Password : " + mdp + " Password Size : " + mdp.length);
    if(minChiffre < 2 || minMajuscule < 2 || minSigne < 2){
        minChiffre = 0; 
        minMajuscule = 0;
        minSigne = 0;
        mdp = "";
        return randomPassword();
    }
    else {
        return console.log("Password : " + mdp + " Password Size : " + mdp.length)
    }

}

randomPassword();
