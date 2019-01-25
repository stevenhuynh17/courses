.data
music:		.word	66,	73,	71,	70, 	47, 	42, 	43, 	38, 	46, 	35, 	30, 	31, 	26, 	34, 	35, 	33, 	35, 	77, 	84, 	82, 	80, 	30, 	28, 	30
duration:	.word	250,	250, 	500, 	300, 	4000,	4000,	4000,	2000,	2000,	4000,	4000,	4000,	2000,	2000,	250,	250,	2000,	250,	250,	500,	500,	250,	250, 	2000
iterator: 	.word	0
size:		.word	24

.text
main:
la $t0, music		# Load address of music array
la $t1, duration	# Load address of duration array

lw $t2, iterator	# Load word value of iterator
lw $t3, size		# Load word value of size


begin_loop:
beq $t2, $t3, exit_loop	# if size and iterator equal, exit loop

sll $t4, $t2, 2		# shift 4 bits from iterator value into new t4 value
addu $t5, $t4, $t0	# t5 represents current index of music
addu $t6, $t4, $t1	# t6 represents current index of duration

lw $s0, 0($t5)		# Load word from current index of music and save it into S0
lw $s1, 0($t6)		# Load word from current index of duration and save it into S1

li $v0, 33		# Instruct to print number
la $a0, ($s0)		# Note input
la $a1, ($s1)		# Duration input
la $a2, 0		# Piano instrument
la $a3, 127		# Loudest volume
syscall

addi $t2, $t2, 1	# Increment iterator by 1
j begin_loop

exit_loop: