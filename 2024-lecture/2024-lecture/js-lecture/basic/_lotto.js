// 중복방지 하려면?
// 1 ~ 45 숫자 나열 후에 랜덤하게 뽑기
// 1 ~ 45 섞어넣고 앞에서 6장 뽑기

// console.log(Math.floor(Math.random() * 45 + 1));
const nums = [];
let i;
for (let i = 0; i < 45; i = i + 1) {
  nums[i] = i + 1;
}
//console.log("for 문 빠져나옴");
// console.log(nums);
//console.log(nums[Math.floor(Math.random() * 45)]);

for (let j = 0; j < 6; j++) {
  console.log(nums.splice(Math.floor(Math.random() * nums.length), 1).pop());
  // 뒤에 .pop() 안하면 배열이 떨어져나옴, 숫자가 아니라
  // splite의 기본 리턴값은 배열임
}
console.log(nums);
// console.log(nums.splice(Math.floor(Math.random() * 45), 1));
// console.log(nums.splice(Math.floor(Math.random() * 44), 1));
// console.log(nums.splice(Math.floor(Math.random() * 43), 1));
// console.log(nums.splice(Math.floor(Math.random() * 42), 1));
// console.log(nums.splice(Math.floor(Math.random() * 41), 1));
// console.log(nums.splice(Math.floor(Math.random() * 40), 1));

// const animals = ["tiger", "cat", "lion", "bear"];
// console.log(animals.pop()); // pop()은 마지막 요소를 제거
// // 하지만 앞선 배열에 영향을 끼친다
// console.log(animals);
// console.log(animals.shift()); // shift는 맨앞 요소를 제거
// console.log(animals);
// animals.push("dog"); // 맨 뒤에 집어넣음
// animals.unshift("frog"); //맨 앞에 넣기, 하지만 별로 좋은 선택은 아님
// console.log(animals);
// // animals.splice(1, 1);
// console.log(animals.splice(1, 2)); // animal 배열에서 1,2번째 인덱스에 있는 값을 배열에서 제거
// console.log(animals);
