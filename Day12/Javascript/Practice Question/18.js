let number = 287152;

let sum = 0;

while(number > 0 ){
    let lastDIgit = number % 10;
    sum = sum  + lastDIgit;
    number = Math.floor(number / 10);
}

console.log(sum);