const eliminar = require('../models/personajes')

exports.borrarPersonajes = (req,res)=>{
eliminar.findByIdAndDelete(req.params.id)
.then(personajeBorrado =>{
    console.log("Usuario borrado exitosamente")
}).catch(error =>
    {
        res.json({error:"Usuario no se a podido borrar "})
    })
};