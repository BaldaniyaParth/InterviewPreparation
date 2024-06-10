let arr = [15,45,36,75,12,98,17,36];

let largest = arr[0];
for(let i=1; i<arr.length; i++){
    if(largest < arr[i]){
        largest = arr[i]
    }
}

console.log(largest);