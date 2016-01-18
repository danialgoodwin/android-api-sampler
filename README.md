# android-api-sampler
See Android APIs in action before deciding to use them or not.

It would be nice to see examples of how different Android APIs may look without creating new projects first. So, this project is for everybody that has ever thought that.



## How to Contribute

1. In api-sampler/app/src/main/java/net/simplyadvanced/androidapisampler/viewsample, add a new class that `implements ViewSample` .
2. In `SamplerData.java`, add a new instance of that class you created to the ViewSamples list.
3. Test.
4. Send pull request.

Eventually, if there seems to be need, we might just automatically instantiate all the ViewSamples in that folder so that step two wouldn't be needed.



## License
MIT
