/* Código simplório, apenas para fornecer o serviço para a aplicação */

var express = require('express')
var app = express()
var routes = require('../app/routes')
var path =  require('path')
var bodyParser = require('body-parser');

app.use(bodyParser.json());

app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});

routes(app);

module.exports = app;