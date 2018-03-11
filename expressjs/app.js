const express = require('express')
const app = express()

app.get('/', (req, res) => res.send('OK'))

app.get('/2ms', (req, res) =>
  setTimeout(() => {
    res.send('OK')
  }, 2)
)
app.get('/5ms', (req, res) =>
  setTimeout(() => {
    res.send('OK')
  }, 5)
)
app.get('/10ms', (req, res) =>
  setTimeout(() => {
    res.send('OK')
  }, 10)
)


app.listen(8080, () => console.log('Example app listening on port 8080!'))
