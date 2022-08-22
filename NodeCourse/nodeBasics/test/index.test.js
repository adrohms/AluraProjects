const takeFile = require('../index');

const expectedArray = [
    {
        FileList: 'https://developer.mozilla.org/pt-BR/docs/Web/API/FileList'
    }
]

describe('TakeFile::', () => {
    it('Must be a function', () =>{
        expect(typeof takeFile).toBe('function');
    })
    it('Must return a array of objects', async () => {
        const result = await takeFile('test/testFiles/text01.md');
        expect(result).toEqual(expectedArray);
    })
    it('Throw error when path is miss informed', async () => {
        await expect(takeFile('/home/adriel/Documents/Alura/Typescript/typescript-curso-1-2/nodeReview/test/testFiles/text03.md')).rejects.toThrow('Presta atenção seu fudido!')
      })
    it('Must inform that dosnt exist any link', async () => {
        const result = await takeFile('/home/adriel/Documents/Alura/Typescript/typescript-curso-1-2/nodeReview/test/testFiles/text02.md');
        expect(result).toBe('There is no links to be extracted!');
    })
    
});