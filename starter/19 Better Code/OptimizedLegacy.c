/*Here are some improvements that can be made to the code:

Use meaningful function and variable names: The current names don't provide any information about what they represent. This makes the code harder to understand and maintain.

Error handling: Instead of exiting the program when a file can't be opened, it would be better to return an error code or throw an exception. This would allow the caller to decide how to handle the error.

Code duplication: The code for opening a file and checking if it was opened successfully is duplicated in several places. This could be moved to a separate function.

Use of global constants: The filename "crud.txt" and "temp.txt" are hardcoded in several places. It would be better to define them as global constants.

Use of magic numbers: The number 100 is used as the size of several arrays. It would be better to define it as a global constant.*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 100
#define FILENAME "crud.txt"
#define TEMP_FILENAME "temp.txt"

FILE* open_file(const char* filename, const char* mode) {
    FILE* file = fopen(filename, mode);
    if (file == NULL) {
        printf("Unable to open the file.\n");
        return NULL;
    }
    return file;
}

void create_data() {
    char data[MAX];
    FILE *file = open_file(FILENAME, "a");
    if (file == NULL) return;

    printf("Enter data: ");
    fgets(data, MAX, stdin);
    fputs(data, file);
    fclose(file);
}

void read_data() {
    char data[MAX];
    FILE *file = open_file(FILENAME, "r");
    if (file == NULL) return;

    printf("Data in the file:\n");
    while (fgets(data, MAX, file) != NULL)
        printf("%s", data);
    fclose(file);
}

void update_data() {
    char old_data[MAX], new_data[MAX];
    FILE *file = open_file(FILENAME, "r");
    FILE *temp_file = open_file(TEMP_FILENAME, "w");
    int found = 0;

    printf("Enter data to be updated: ");
    fgets(old_data, MAX, stdin);
    printf("Enter new data: ");
    fgets(new_data, MAX, stdin);

    char current_data[MAX];
    while (fgets(current_data, MAX, file) != NULL) {
        if (strcmp(current_data, old_data) == 0) {
            fputs(new_data, temp_file);
            found = 1;
        } else {
            fputs(current_data, temp_file);
        }
    }

    fclose(file);
    fclose(temp_file);

    remove(FILENAME);
    rename(TEMP_FILENAME, FILENAME);

    if (found == 0)
        printf("Data not found.\n");
    else
        printf("Data updated successfully.\n");
}

void delete_data() {
    char data_to_delete[MAX];
    FILE *file = open_file(FILENAME, "r");
    FILE *temp_file = open_file(TEMP_FILENAME, "w");
    int found = 0;

    printf("Enter data to be deleted: ");
    fgets(data_to_delete, MAX, stdin);

    char current_data[MAX];
    while (fgets(current_data, MAX, file) != NULL) {
        if (strcmp(current_data, data_to_delete) != 0)
            fputs(current_data, temp_file);
        else
            found = 1;
    }

    fclose(file);
    fclose(temp_file);

    remove(FILENAME);
    rename(TEMP_FILENAME, FILENAME);

    if (found == 0)
        printf("Data not found.\n");
    else
        printf("Data deleted successfully.\n");
}

int main() {
    int choice;

    while (1) {
        printf("\n1. Create\n2. Read\n3. Update\n4. Delete\n5. Exit\nEnter your choice: ");
        scanf("%d", &choice);
        getchar();  // To consume newline character

        switch (choice) {
            case 1:
                create_data();
                break;
            case 2:
                read_data();
                break;
            case 3:
                update_data();
                break;
            case 4:
                delete_data();
                break;
            case 5:
                exit(0);
            default:
                printf("Invalid choice.\n");
        }
    }

    return 0;
}