const fetch = require('node-fetch');

function errorTreatment(error) {
    throw new Error(error.message);
}

function generateHTTPList(processedFile){
    return processedFile.map( item => Object.values(item).join());
}

async function generateStatusList(httpList){
    try{
        const statusList = await Promise.all(
            httpList.map( async url => {
                const response = await fetch(url);
                return response.status;
            })
        );
        return statusList;
    } catch(error){
        errorTreatment(error);
    }

}

async function validateHTTP(processedFile) {
    const httpList =  generateHTTPList(processedFile);

    try {
        const statusList = await generateStatusList(httpList);
        return statusList;
    } catch(error){
        errorTreatment(error);
    }

}

module.exports = validateHTTP;