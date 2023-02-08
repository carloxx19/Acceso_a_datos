const mongoose = require("mongoose");

const mongoUrl = "mongodb+srv://root:root@cluster0.1cqxnav.mongodb.net/rickAndMorty?retryWrites=true&w=majority"
mongoose.set('strictQuery',true)
mongoose.connect(mongoUrl,
     {useNewUrlParser:true,
        useUnifiedTopology:true})
.then(()=>console.log('base de datos conectada')).catch(()=> console.log("error"));