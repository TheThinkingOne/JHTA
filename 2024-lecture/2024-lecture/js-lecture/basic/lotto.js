// 주소만 가져다 쓰는것이기 때문에 빈 배열은 마음껏 가져다 쓸 수 있다(const 라고 하더라도)
// const numsCopy = nums; // shallow copy => 얕은 복사(주소값만 복사)
// nums[0] = 1;
// nums[1] = 2;
// nums[2] = 3;
// nums[3] = 4;
// nums[4] = 5;
// nums[5] = 6;
// console.log(numsCopy);

const magician = {
  name: "Emma Hardy",
  age: 21,
  gender: "female",
};

const copymagic = magician;
copymagic.name = "Summer Pardy Magician Emma";
console.log(copymagic);

const nums = [];
for (let i = 0; i < 45; i++) {
  //num[i] = i + 1;
  nums.push(i + 1);
}
console.log(nums);

const selectedNums = [];
for (let i = 0; i < 6; i++) {
  selectedNums.push(
    nums.splice(Math.floor(Math.random() * nums.length), 1).pop()
  );
}
for (let j = 0; j < selectedNums.length; j++) {
  console.log(selectedNums[j]);
}
