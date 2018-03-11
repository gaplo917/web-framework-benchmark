<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$router->get('/', function () use ($router) {
    return "OK";
});

$router->get('/2ms', function () use ($router) {
    sleep(0.002);
    return "OK";
});

$router->get('/5ms', function () use ($router) {
    sleep(0.005);
    return "OK";
});

$router->get('/10ms', function () use ($router) {
    sleep(0.01);
    return "OK";
});
