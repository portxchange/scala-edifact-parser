# Scala EDIFACT parser


## Installation
`libraryDependencies += "com.portofrotterdam" %% "scala-edifact-parser" % "0.0.1"`


## Message Types
Currently we only support the [IFTSAI](http://www.unece.org/trade/untdid/d12a/trmd/iftsai_c.htm) message type and its segments

## Segments

### Supported segments
- [Interchange Header](https://www.stylusstudio.com/edifact/40100/UNB_.htm)
- [Message Header](http://www.unece.org/trade/untdid/d12a/trsd/trsdunh.htm)
- [Beginning of Message](http://www.unece.org/trade/untdid/d12a/trsd/trsdbgm.htm)
- [Transport Information](http://www.unece.org/trade/untdid/d12a/trsd/trsdtdt.htm)
- [Reference](http://www.unece.org/trade/untdid/d12a/trsd/trsdrff.htm)
- [Free Text](http://www.unece.org/trade/untdid/d12a/trsd/trsdftx.htm)
- [Location](http://www.unece.org/trade/untdid/d12a/trsd/trsdloc.htm)
- [Date/Time/Period](http://www.unece.org/trade/untdid/d12a/trsd/trsddtm.htm)
- [Message Trailer](http://www.unece.org/trade/untdid/d12a/trsd/trsdunt.htm)

### Unsupported segments
- [Communication Contact](http://www.unece.org/trade/untdid/d12a/trsd/trsdcom.htm)
- [Contact Information](http://www.unece.org/trade/untdid/d12a/trsd/trsdcta.htm)
- [Dangerous Goods](http://www.unece.org/trade/untdid/d12a/trsd/trsddgs.htm)
- [Dimensions](http://www.unece.org/trade/untdid/d12a/trsd/trsddim.htm)
- [Equipment Details](http://www.unece.org/trade/untdid/d12a/trsd/trsdeqd.htm)
- [Number of Units](http://www.unece.org/trade/untdid/d12a/trsd/trsdeqn.htm)
- [Nature of Cargo](http://www.unece.org/trade/untdid/d12a/trsd/trsdgds.htm)
- [Processing Information](http://www.unece.org/trade/untdid/d12a/trsd/trsdgei.htm)
- [Goods Item Details](http://www.unece.org/trade/untdid/d12a/trsd/trsdgid.htm)
- [Handling Instructions](http://www.unece.org/trade/untdid/d12a/trsd/trsdhan.htm)
- [Measurements](http://www.unece.org/trade/untdid/d12a/trsd/trsdmea.htm)
- [Name and Address](http://www.unece.org/trade/untdid/d12a/trsd/trsdnad.htm)
- [Quantity](http://www.unece.org/trade/untdid/d12a/trsd/trsdqty.htm)
- [Transport Placement](http://www.unece.org/trade/untdid/d12a/trsd/trsdtpl.htm)
- [Transport Service Requirements](http://www.unece.org/trade/untdid/d12a/trsd/trsdtsr.htm)


## Future Work
- Implement other segments
- Cross compile Scala 2.13
- Date formats for Date/Time/Period segment
