# $(1) : compiler
# $(2) : source file .java
# $(3) : classpath
# $(4) : object file .class
# $(5) : folder for object files
define COMPILE
$(4) : $(2)
	$(1) $(2) $(3) -d $(5)
endef

define TO
$(patsubst %.java,%.class,$(patsubst $(SRC)%,$(OBJ)%,$(1)))
endef

GAME	   := PlayExtremeFighter.java
JC         := javac
#JVFLAGS   :=
MKDIR      := mkdir -p
SRC        := src
OBJ        := obj
SUBDIRS    := $(shell find $(SRC) -type d)
OBJSUBDIR  := $(patsubst $(SRC)%,$(OBJ)%,$(SUBDIRS))
ALLJAVAS   := $(shell find $(SRC) -type f -iname *.java)
AllCLASS   := $(foreach F,$(ALLJAVAS),$(call TO,$(F)))
CLASSPATH  := -cp $(SRC)

.PHONY: info clean run

$(GAME) : $(OBJSUBDIR) $(AllCLASS)
	java -cp $(OBJ) $(SRC)/$(GAME)

$(foreach F,$(ALLJAVAS),$(eval $(call COMPILE,$(JC),$(F),$(CLASSPATH),$(call TO,$(F)),$(OBJ))))

#%.class	: %.java
#	$(JC) $^ $(INCLUDE) -d $(OBJ)

info:
	$(info $(SUBDIRS))

	$(info $(OBJSUBDIR))
	
	$(info $(ALLJAVAS))

	$(info $(AllCLASS))

$(OBJSUBDIR):
	$(MKDIR) $(OBJSUBDIR)

clean:
	rm -r $(OBJ)
run:
	java -cp $(OBJ) $(SRC)/$(GAME)
	
