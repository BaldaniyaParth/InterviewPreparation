#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Structure Definitions
struct items {
    char item[20];
    float price;
    int qty;
};

struct orders {
    char customer[50];
    char date[50];
    int numofItems;
    struct items itm[50];
};

// Function Prototypes
void generateBillHeader(char name[50], char date[30]);
void generateBillBody(char item[20], int qty, float price);
void generateBillFooter(float total);

int main() {
    int opt, n;
    char name[50];
    char saveBill = 'y', flag = 'y';
    FILE *fp;

    while (flag == 'y') {
        float total = 0;
        int i = 0;
        struct orders ord;
        struct orders order;

        printf("===============================================================Parth Cafe=============================================================\n");
        printf("1. Generate Invoice\n");
        printf("2. Show all Invoices\n");
        printf("3. Search Invoices\n");
        printf("4. Exit\n");
        printf("\nYour Choice: ");
        scanf("%d", &opt);

        printf("\nYour Choice is %d", opt);
        printf("\n");

        switch (opt) {
            case 1:
                printf("\nPlease Enter the Name of Customer:  ");
                fgetc(stdin);
                fgets(ord.customer, 50, stdin);
                ord.customer[strlen(ord.customer) - 1] = '\0';
                strcpy(ord.date, __DATE__);
                printf("\nPlease Enter the number of items:  ");
                scanf("%d", &n);
                ord.numofItems = n;

                for (int i = 0; i < n; i++) {
                    fgetc(stdin);
                    printf("\n\n");
                    printf("\nPlease Enter the item %d:  ", i + 1);
                    fgets(ord.itm[i].item, 20, stdin);
                    ord.itm[i].item[strlen(ord.itm[i].item) - 1] = '\0';
                    printf("\nPlease Enter the Quantity:  ");
                    scanf("%d", &ord.itm[i].qty);
                    printf("\nPlease Enter the unit price:  ");
                    scanf("%f", &ord.itm[i].price);
                    total += ord.itm[i].qty * ord.itm[i].price;
                }

                generateBillHeader(ord.customer, ord.date);

                for (int i = 0; i < ord.numofItems; i++) {
                    generateBillBody(ord.itm[i].item, ord.itm[i].qty, ord.itm[i].price);
                }

                generateBillFooter(total);

                printf("\nDo you want to save your invoice [y/n]:\t");
                scanf("%s", &saveBill);
                if (saveBill == 'y') {
                    fp = fopen("ParthCafe.txt", "a+");
                    fwrite(&ord, sizeof(struct orders), 1, fp);
                    if (fwrite != 0) {
                        printf("\nSaved Successfully");
                    } else {
                        printf("\nError Saving");
                    }
                    fclose(fp);
                }

                break;

            case 2:
                fp = fopen("ParthCafe.txt", "r");
                printf("\n*****************************************Previous Invoices***************************************");
                while (fread(&order, sizeof(struct orders), 1, fp)) {
                    float tot = 0;
                    generateBillHeader(order.customer, order.date);
                    for (int i = 0; i < order.numofItems; i++) {
                        generateBillBody(order.itm[i].item, order.itm[i].qty, order.itm[i].price);
                        tot += order.itm[i].qty * order.itm[i].price;
                    }
                    generateBillFooter(tot);
                }
                fclose(fp);

                break;

            case 3:
                printf("\nEnter the name of customer: ");
                fgetc(stdin);
                fgets(name, 50, stdin);
                name[strlen(name) - 1] = '\0';

                fp = fopen("ParthCafe.txt", "r");
                printf("\n*****************************************Invoices of %s***************************************", name);
                while (fread(&order, sizeof(struct orders), 1, fp)) {
                    float tot = 0;
                    if (!strcmp(order.customer, name)) {
                        generateBillHeader(order.customer, order.date);
                        for (int i = 0; i < order.numofItems; i++) {
                            generateBillBody(order.itm[i].item, order.itm[i].qty, order.itm[i].price);
                            tot += order.itm[i].qty * order.itm[i].price;
                        }
                        generateBillFooter(tot);
                        i = 1;
                    }
                }

                if (!i) {
                    printf("\nNo invoices found for %s", name);
                }
                fclose(fp);

                break;

            case 4:
                printf("\nExiting...\n");
                exit(0);

            default:
                printf("\nInvalid option! Please try again.\n");
                break;
        }

        printf("\nDo you want to perform another operation? [y/n]\t");
        scanf("%s", &flag);
    }
    printf("\n\n");
    return 0;
}

// Function Definitions
void generateBillHeader(char name[50], char date[30]) {
    printf("\n\n");
    printf("\t\t\t\t\t\t\t\tParth Cafe\t\t\t\t\t\t\t\t");
    printf("\n--------------------------------------------------------------------------------------------------------------------------------------\n");
    printf("\nDate: %s", date);
    printf("\nInvoice to: %s", name);
    printf("\n--------------------------------------------------------------------------------------------------------------------------------------\n");
    printf("Items\t\t");
    printf("Quantity\t\t");
    printf("Total\t\t");
    printf("\n--------------------------------------------------------------------------------------------------------------------------------------\n");
    printf("\n");
}

void generateBillBody(char item[20], int qty, float price) {
    printf("%s\t\t", item);
    printf("    %d\t\t", qty);
    printf("        %.2f\t\t", qty * price);
    printf("\n");
}

void generateBillFooter(float total) {
    printf("\n");
    float dis = 0.1 * total;
    float netTotal = total - dis;
    float gst = 0.18 * netTotal;
    float grandTotal = netTotal + gst;
    printf("\n--------------------------------------------------------------------------------------------------------------------------------------\n");
    printf("\nSub Total\t\t\t%.2f", total);
    printf("\nDiscount @10%%\t\t\t%.2f", dis);
    printf("\n--------------------------------------------------------------------------------------------------------------------------------------\n");
    printf("\nNet Total\t\t\t%.2f", netTotal);
    printf("\nGST @18%%\t\t\t%.2f", gst);
    printf("\n--------------------------------------------------------------------------------------------------------------------------------------\n");
    printf("\nGrand Total\t\t\t%.2f", grandTotal);
    printf("\n--------------------------------------------------------------------------------------------------------------------------------------\n");
}
