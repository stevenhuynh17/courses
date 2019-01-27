.data
space: .asciiz " "
input_prompt: .asciiz "Input row "
colon: .asciiz ": "
new_line: .asciiz "\n"
char: .space 2 
array: .space 33 
output_prompt: .asciiz "\Row "

.text
#Initializing data
li $t9, 1				# initialize counter to 1
la $s1, array 				# set base address of array to s1

# Loop to display prompt for input
prompt_loop: 
beq $t9, 5, exit_dataEntry 		# exit loop when 5th iteration is reached
la $a0, input_prompt 			# load prompt message into $a0 
li $v0, 4 				# print string 
syscall 

la $a0, ($t9) 				# load prompt message into $a0 
li $v0, 1 				# print string  
syscall
 
la $a0, colon 				# load colon into $a0 
li $v0, 4 				# print string
syscall

# Input data loop
data_input:

jal process_data			# jump to the process_data 'function'

# Store input
lb $t0, char 				# load the char from char buffer into t0  
sb $t0, 0($s1) 				# store the char into array

# Input new line if needed
lb $t1, new_line 			# load new_line into t1 
beq $t0, $t1, increment_counter 	# check to see if end of string

# Checking for space
lb $t1, space 				# load newline char into t1 
beq $t0, $t1, data_input 		# keeps going as though nothing has happened if we run across a space
addi $s1, $s1, 1 			# increments base address of array j

# Read char and save input
process_data:
li $v0, 8 				# read string 
la $a0, char 				# load address of char
li $a1, 2 				# 2 to represent length of string
syscall 				# store the char byte from input buffer into char 
jr $ra 					# jump-register to exit 'function'


# Increments counter when encountering a newline
increment_counter:
addi $t9, $t9, 1			# increment counter
j prompt_loop 				# jumps back to prompt_loop because for new line

# Reset everything
exit_dataEntry:
addi $t9, $t9, -4 			# resets the counter because the way we have it set up we increment it again to echo everything in the right order
la $s1, array 				# loads the array back into $s1

# Display saved data
output_data:
beq $t9, 5, finish_program		# exit loop when 5th iteration is reached
la $a0, output_prompt 			# load output prompt to $a0
li $v0, 4 				# print string 
syscall 
	

li $v0, 1 				# print int 
la $a0, ($t9) 				# load prompt message into $a0  
syscall

la $a0, colon 				# load prompt message into $a0  
li $v0, 4 				# print string 
syscall 

li $t3, 1 				# counter
 
# Convert string to integer
string_to_integer: 
beq $t3, 5, output_counter_increase 
lb $a0,($s1) 				# load byte of the first char
lb $t1, new_line 			# load newline char into t1
beq $a0, $t1, finish_program 		# check for end of string
 
addi $a0, $a0,-48 			# turns ascii to int
li $v0, 1 				# print int 
syscall 

la $a0, space 				# load prompt message into $a0
li $v0, 4 				# print string 
syscall 
addi $s1, $s1, 1 			# increments base address of array
addi $t3,$t3,1 				# increment counter
j string_to_integer 			# loops back itself
 
#increments output counter
output_counter_increase: 
addi $t9, $t9, 1 			# increment by 1
j output_data 				# back to the loop again
 
#ends the program
finish_program: 
li $v0, 10 				#exits
syscall
