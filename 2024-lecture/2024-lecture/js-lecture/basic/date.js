const current = new Date();
const yoil = ["Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"];
console.log(current);

const currentDay = current.getDay();
//getDay 같은 것은 내장객체임
console.log(yoil[currentDay]);
console.log(currentDay);

const plusThree = function (num) {
  return num + 3;
  console.log("끝");
  // return 밑에 있는 문장은 실행 되지 않는다. => 프로그램 규칙임
};

const jegop = function (num) {
  return num * num;
};

const mod = function (num1, num2) {
  return num1 % num2;
};

const myNumberFunction = {
  // object 묶음
  plusThree: function (num) {
    return num + 3;
  },
  jegop: function (num) {
    return num * num;
  },
  mod: function (num1, num2) {
    return num1 % num1;
  },
};

myNumberFunction.plusThree(3);

console.log(myNumberFunction.plusThree(3));
console.log(myNumberFunction["plusThree"](3));

//return을 하지 않으면 기본적으로 undefined 를 반환한다

console.log(plusThree(6974));
console.log(jegop(6974));
console.log(mod(10, 3));

//언제가 되면 만족할 수 있을까.
//지금 당장 멈춰도 좋을 정도로 만족할 수 있는 지점.
//그게 있기는 한걸까.
//나는 그걸 납득할 수 있을까.
//내가 할 수 있는건, 그저 별을 따라가는 것 뿐.
