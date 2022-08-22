const chalk = require('chalk');
const fs = require('fs');

function linkExtractor(text){
    const regex = /\[([^.]*)\]\((https?:\/\/[^*\s].[^\s]*)\)/gm;
    const resultingLinks = [];
    let temp;
    text.replace(regex, "$1 $2")
    
    while((temp = regex.exec(text)) !== null) {
        resultingLinks.push({
            [temp[1]]: temp[2]
        });
    }

    return resultingLinks.length === 0 ? 'There is no links to be extracted!' : resultingLinks;
}

function errorTreatment(err){
    throw new Error(chalk.red(err), 'Presta atenção seu fudido!');
}

async function takeFile(filePath){
    const encoding = 'UTF-8';

    try {
        const text = await fs.promises.readFile(filePath, encoding);
        return linkExtractor(text);
    
    } catch(err) {
        errorTreatment(err);
    }

}

/* function takeFile(filePath){
    const encoding = 'UTF-8';
    fs.promises
    .readFile(filePath, encoding)
    .then( text => console.log(chalk.magenta(text)))
    .catch( err => errorTreatment(err));
} */

/* function takeFile(filePath){
    const encoding = 'UTF-8';
    fs.readFile(filePath, encoding, (err ,text) => {
        if(err){
            errorTreatment(err);
        }
        console.log(chalk.magenta(text));
    })
} */

//console.log(chalk.green('lets get start in here!'));

//takeFile('./textFiles/text01.md');

module.exports = takeFile;