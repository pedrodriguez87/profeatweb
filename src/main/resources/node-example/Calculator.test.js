const Calculator = require('./Calculator'); //imports the calculator class

test('Calculator can add numbers', () => {

    const calc = new Calculator();
    calc.add(2);
    calc.add(3);

    expect(calc.value).toBe(5);
});
