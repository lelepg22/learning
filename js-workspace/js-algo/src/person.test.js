const Person = require('./structure');
const jl = new Person("Jean-Luc", 54);

test('Person should be instanciated', ()=> {    
    expect(jl).toBeInstanceOf(Person);    
});

test('lastName input of the instance', ()=> {
    expect(jl.lastName).toEqual("Jean-Luc");
});
test('age input of the instance', () => {
    const jl = new Person("Jean-Luc", 54);
    expect(jl.age).toBe(54);
})

test(`Should say 'Bonjour, je m'appelle Jean-Luc, j'ai 54 ans`, ()=> {
    const jl = new Person("Jean-Luc", 54);
    expect(jl.sayHello()).toBe(`Bonjour, je m'appelle Jean-Luc, j'ai 54 ans`);
});

test(`Should be true`, ()=> {
    expect(jl.setAge(10)).toBeTruthy();
    expect(jl.age).toBe(10);
})

// test(`Should throw error`, ()=> {
//     expect(jl.setAge(200)).toThrow()
// })
