var express = require('express');
var router = express.Router();
var personajesController = require('../controllers/personajesController')


/* GET users listing. */
router.get('/', personajesController.verPersonajes);

module.exports = router;
