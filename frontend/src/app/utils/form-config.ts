export interface FormConfig {
    [control: string]: {
        type: 'text' | 'password',
        validation: 'none' | 'required'
    }
}