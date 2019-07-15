//window.addEventListener("load", init, false);


/*
function init() {
  //Regular function

  helloFunc = function () {
    return "Hello world!";
  }

  //arrow function version

  arrowHello = () => {
    return "Hello World!";
  }

  var hello = helloFunc();
  var arrow = arrowHello();
  console.log(hello);
  console.log("Now doing arrow function:");
  console.log(arrow);
}
*/
console.log("1. Testing basic 'hello world' in regular and arrow functions");
//regular function
helloFunc = function () {
  return "Hello World!";
}
//arrow function
arrowHello = () => {
  return "Hello World!";
}
console.log("Regular func:");
console.log(helloFunc);
console.log("Returns: " + helloFunc());
console.log("Arrow Function:");
console.log(arrowHello);
console.log("Returns: " + arrowHello());

console.log("2. If the function only has one statement, it can be shortened");
shortHello = () => "Hello World";
console.log(shortHello);
console.log("Returns: " + shortHello());

console.log("3. if you only have one parameter, you can even skip parentheses");
let word = "World!";
//noParHello = word => `Hello ${word}`;
noParHello = (word) => "Hello " + word;
console.log(noParHello);
console.log("Returns: " + noParHello(word));


console.log("Testing usage of => in method function (will be undefined)");
var obj = {
  i: 10,
  b: () => console.log(this.i, this),
  c: function () {
    console.log(this.i, this);
  }
}
obj.b(); //prints undefined, Window{...}
obj.c(); //prints 10
