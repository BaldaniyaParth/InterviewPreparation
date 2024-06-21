#include<stdio.h>

void copy_arr(char *arr, int size, char *new_arr);
void print_arr(char arr[], int size);

int main() {
  char arr[5] = {'P', 'a', 'r ', 't', 'h'};
  char new_arr[5];

  printf("Welcome to coping array using pointer arithmetic\n\n");
  printf("\nOriginal char array: ");
  print_arr(arr, 5);
  copy_arr(arr, 5, new_arr);
  printf("\nCopied char array: ");
  print_arr(new_arr, 9);

  return 0;
}

void copy_arr(char *arr, int size, char *new_arr) {
  for (int i = 0 ; i < size; i++) {
    *(new_arr + i) = *(arr + i);
  }
}

void print_arr(char arr[], int size) {
  for (int i = 0; i < size; i++) {
    printf("%c", arr[i]);
  }
}