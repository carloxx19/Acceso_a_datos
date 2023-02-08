var express = require('express');
var router = express.Router();
var eliminar = require('../controllers/eliminarIdController')

/* GET users listing. */
router.get("/:id", eliminar.borrarPersonajes);

module.exports = router;