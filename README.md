# data-storage
Data storage format I will use for everything
The specs are as below
# Binary Tags
Simple way of storing data.
## Format
The format for the tags.
### Basic Binary Formats (unrelated to tags)
All numbers (byte, short, int, long) are stored as little endian.
Sizes (bytes):
- byte: 1
- short: 2
- int: 4
- long: 8

Strings are stored as a integer first, then a series of bytes length n, where n is the integer. The bytes are intepreted as UTF8
### Tag ids
All tags must have an ID.
- TAG_NULL = 0
- TAG_OBJECT = 1
- TAG_ARRAY = 2
- TAG_BYTE = 3
- TAG_SHORT = 4
- TAG_INT = 5
- TAG_LONG = 6
- TAG_FLOAT = 7
- TAG_DOUBLE = 8
- TAG_STRING = 9
### Exact specs
**TAG_NULL**  
*ID = 0*    
*size = 0*  
No data, just the ID.   
**TAG_OBJECT**  
Container object, contains (n) elements.  
*ID = 0*  
*size = sizeof(TAG_INT) + (1 + sizeof(name) + sizeof(child))  n*  
Like all container objects, it first contains a integer, which is n (the amount of elements)  
Then, n repeating units of this structure:  
- string name
- byte id
- serialize version of the tag it contains

**TAG_ARRAY**  
Container object, contains (n) elements.  
*ID = 0*  
*size = sizeof(TAG_INT) + (1 + sizeof(child))  n*  
Like all container objects, it first contains a integer, which is n (the amount of elements)  
Then, n repeating units the serialized version of the tag it contains  
**TAG_BYTE, TAG_SHORT, TAG_INT, TAG_LONG**  
*id = 3,4,5,6*  
*size = sizeof(tag_type)*  
The raw representation of the integers types. Nothing has changed from the primitives  
IDK HOW TO DOCUMENT FLOATS AND SHIT  
**TAG_STRING**  
*id = 9*  
*size = sizeof(TAG_INT) * n*  
The raw representation of string.  
**TAG_FLOAT,TAG_DOUBLE**  
*id=7,8*  
*size = sizeof(tag_type)*  
The raw representation of the floating-point types  
