li $v0,4 		# load service number for string print in $v0
la $a0,name 		# load address of string to be printed into $a0
syscall

li $v0,8 		# read a string
la $a0,buffer		# address of input buffer
la $a1,20		# max character length
move $t0,$a0		# save input into t0
syscall 		# read value goes into v0

li $v0,4		# prepare to print string
la $a0,age		# load address of string to print
syscall

li $v0,5		# read an integer
syscall 		# read value goes into v0

addi $t1,$v0,4

li $v0,4		# print a string
la $a0,response_1	# load address location for the prompt
syscall			# read value goes into $v0

li $v0,4		# print a string
la $a0,buffer		# load address location for name response
syscall			# read value goes into $v0

li $v0,4
la $a0,response_2
syscall

li $v0,1
move $a0,$t1
syscall

li $v0,4
la $a0,response_3
syscall

# the null-terminated string must be defined in data segment
.data
name: .asciiz "What is your name? "
age: .asciiz "What is your age? "
buffer: .space 20

response_1: .asciiz "Hello, "
response_2: .asciiz "You will be "
response_3: .asciiz " years old in four years"
