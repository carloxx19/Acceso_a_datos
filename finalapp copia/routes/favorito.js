var express = require('express');
var router = express.Router();
var favoritoController = require('../controllers/favoritoController')

/* GET users listing. */
router.get('/', favoritoController.verFavorito);

module.exports = router;