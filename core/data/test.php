<?php
shell_exec("javac json/Main.java");
$output = shell_exec("java json/Main 1");
echo $output;