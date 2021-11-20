export interface FormConfig {
    [control: string]: {
        type: 'text' | 'password' | 'file',
        validation: 'none' | 'required'
    }
}