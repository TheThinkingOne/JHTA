const nums = [1, 2, 3, 4, 5];

// let [a, b, c, d, e] = nums; //구조분해
// let oldA = nums[0];
// let oldB = nums[1];
// console.log(a, b, c);]

// let [, , c, , e] = nums;
// console.log(c, e);
let [...ccc] = nums;
nums.push(6);
console.log(nums);
console.log(ccc);

let [a, b, ...rest] = nums;
console.log(rest); // rest = [3,4,5]

let aa = 10;
let bb = 20;
[bb, aa] = [aa, bb];
console.log(aa, bb);
