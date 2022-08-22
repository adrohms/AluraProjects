const takeFile = require('./index');
const chalk = require('chalk');
const validateHTTP = require('./http-validator');

const path = process.argv;


async function processFile(filePath) {
    const fileProcessed = await takeFile(filePath[2]);
    
    if( path[3] === '--validate'){
        const statusList = await validateHTTP(fileProcessed);
        //const statusList = [300, 200, 404, 202, 200];

        /* 
        const result = fileProcessed.map( (item, index ) => ({
              ...item,
              status: statusList[index]
        }));
        */

        const result = fileProcessed.map( item => {
            return Object.assign(item, {status: statusList[fileProcessed.indexOf(item)]})    
        });

        
        console.log(result);
    } else {
        console.log(chalk.bgYellow('File processed: '), fileProcessed);
    }
    
    
}

processFile(path);