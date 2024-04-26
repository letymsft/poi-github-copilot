// models/Cat.js
const mongoose = require('mongoose');

const CatSchema = new mongoose.Schema({
  name: String,
  age: Number,
  breed: String,
  photo: String,
  description: String
});

module.exports = mongoose.model('Cat', CatSchema);