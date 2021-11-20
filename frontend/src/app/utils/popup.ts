import { MatSnackBarConfig } from "@angular/material/snack-bar";

export const SNACKBAR_CLOSE_BUTTON = 'Close';
export const SNACKBAR_ERROR_TEXT = 'An error occured! Try again.';

export const SNACKBAR_ERROR_CONFIG: MatSnackBarConfig = {
    horizontalPosition: 'center',
    verticalPosition: 'top',
    panelClass: 'snackbar-error',
    duration: 2000
};
