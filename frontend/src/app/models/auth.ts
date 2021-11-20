export interface Auth {
    email: string;
    password: string;
    role: 'kandidat' | 'tehnicko lice' | 'hr lice' | 'zaposleni u sluzbi nabavke' | 'dobavljac';
    token: string;
}