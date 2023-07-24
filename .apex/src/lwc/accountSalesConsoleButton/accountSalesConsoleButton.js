import { LightningElement, api } from 'lwc';
import { NavigationMixin } from 'lightning/navigation';

export default class AccountSalesConsoleButton extends NavigationMixin(LightningElement) {
    @api accountName;
    @api accountNumber;

    navigateToSalesConsole() {
        // Create the URL to your custom app (Sales Console) with parameters
        const url = '/c/myCustomApp?accountName=' + encodeURIComponent(this.accountName) +
            '&accountNumber=' + encodeURIComponent(this.accountNumber);

        // Navigate to the custom app with parameters
        this[NavigationMixin.Navigate]({
            type: 'standard__webPage',
            attributes: {
                url: url
            }
        });
    }
}
