export interface FormConfig {
    [control: string]: {
        type?: 'text' | 'password' | 'file' | 'location',
        validation: 'none' | 'required'
    }
}

export interface FormStyle {
    width?: string;
    'margin-top'?: string;
}