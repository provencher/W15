# Standard Streams

---
# Task 3 of PA3

```bash
java DiningPhilosophers -7.a

"-7.a" is not a positive decimal integer
Usage: java DiningPhilosophers [NUMBER_OF_PHILOSOPHERS] 
```

##Questions:
#[fit]Where to print out these error messages?

---
# Default standard streams
- Standard input (stdin)
- Standard output (stdout)
- Standard error (stderr)

---
#[fit] Every program has 3 standard streams

---
# Interaction
- stdin as "keyboard"
- stdout as "screen"
- stderr as "error reporter"

---
# Java standard streams
- `System.out` is stdout
- `System.in` is stdin
- `System.err` is stderr

#[fit]Error messages should be written on **stderr** not `stdout`

---
# Redirect
#[fit] Capture output of A then makes it as input of B

---
# Redirect stdout

```bash
# Print out to screen directly
echo "Hello World"

# Redirect stdout to a new file (truncate)
echo "Hello World" > hello.log

# Redirect and append stdout to a file
echo "Hello World" >> hello.log

```

---
# Pipe
Redirect stdout of process A to stdin of process B

```bash
echo "Hello World" | wc
cat langs.txt | wc -l
```

---
#Redirect in detail
```bash
1>filename
  # Redirect stdout to file "filename."
1>>filename
  # Redirect and append stdout to file "filename."
2>filename
  # Redirect stderr to file "filename."
2>>filename
  # Redirect and append stderr to file "filename."
&>filename
  # Redirect both stdout and stderr to file "filename."
```

---
# Mixed redirect & pipe

```bash
cat names.txt | sort > langs.txt
# `cat` reads file `names.txt` then prints in stdout
# stdout of `cat` is redirected to stdin of `sort` (Pipe)
# stdout of sort is redirected to langs.txt
```

---
# Redirect stdin
```bash
sort 0< names.txt > langs.txt
# stdin is from `names.txt`
# stdout is to `langs.txt`
```

---
# References
[http://www.tldp.org/LDP/abs/html/io-redirection.html](http://www.tldp.org/LDP/abs/html/io-redirection.html)



