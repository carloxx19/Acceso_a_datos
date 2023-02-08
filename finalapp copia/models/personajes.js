const mongoose = require('mongoose');

const Schema = mongoose.Schema

const personajesSchema = new Schema({
    name:String,
    status: String,
    species:String,
    gender:String,
    image:String
})

module.exports = mongoose.model('personajes',personajesSchema)