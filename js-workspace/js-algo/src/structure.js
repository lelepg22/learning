class Person {
    constructor(lastName, age){        
        this.lastName = lastName;
        this.age = age;
    }
    
    sayHello() {
        return `Bonjour, je m'appelle ${this.lastName}, j'ai ${this.age} ans`
    }
    setAge(age) {
        if(age >= 0 && age <=150){
            return this.age = age;
        }        
        // else{
        //     throw new Error("Valeur d'age impossible . AGE = " + age );
        // }
    }
} 

const jl = new Person ('Jean-Luc', 54);


module.exports = Person;

/* function newPerson(params1, params2) {

    return console.log(new Person(params1, params2));

}
newPerson('Alex', 35);
*/