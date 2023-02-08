const favorito = require('../models/personajes')

exports.verFavorito = (req, res) => {
    favorito.findById('63d910534fa5466e3441161f' ).then(favorito =>
        res.json({ favorito })
    )
}