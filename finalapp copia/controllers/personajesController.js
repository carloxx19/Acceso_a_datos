const personajes = require('../models/personajes')

exports.verPersonajes=(req,res)=>{
personajes.find().then(personajes=>{
    res.json({personajes})
})
}