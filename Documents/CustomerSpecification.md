# Customer Specification

> This document is a Work in Progress.

## Brief

Our client needs an application called SpringTunes that will allow users to share music online with other users, and also allow other users to engage with user-created content by liking, commenting-on, saving tracks into a playlist or following other users. Users do not need to be signed in to listen to tracks, but they must be signed in to engage.

## Engagement

### Commenting
When commenting on a track, users will be able to place comments at a timestamp, which will be reflected on the tracks controls.

### Liking
Liking a track will increase the number of likes for the song, and also display the track under the users profile under "Liked tracks". Liking a track is public.

### Saving to playlist
Saving a track to a playlist will display that track in the users playlist. See the Playlist section for more information on Playlists.

### Following users
Users will also be able to follow other users, which will show them a notification when their followed artists upload a new track. Users must be able to control the level of notifications that they receive, and how they receive them. Forms of notification will include "Notification" (which will be a notification on the website), and "Email".


## Payment tiers

SpringTunes shall contain a number of payment tiers:

- Free
    - Standard-quality playback
    - Cannot create albums
    - Up to 25 tracks
    - 2 private lists
    - Unlimited public lists
    - Cannot rewind tracks
    - Cannot sell tracks
    - Advertisements during playback
- - -
- Hobbyist (£4.99 / month)
    - Standard-quality playback
    - Up to 80 tracks
    - 10 private lists
    - Ability to rewind tracks
    - 10% charge on all sold tracks
    - No advertisements
- - -
- Professional (£9.99 / month)
    - High-quality playback
    - Unlimited tracks
    - Unlimited private lists
    - 2% charge on all sold tracks
    - Customizeable profile page
    - "Upcoming gigs" feature

The payment tier subscriptions must be handled automatically by a payment system.
Users must be able to change their payment-tier at any point, which will queue the change at their next payment date. Switching to a free tier will cancel any existing payment subscriptions. Must have support for switching to free and back to a paid subscription tier in a single subscription-cycle.

## Registration and Authentication

Users will be able to register via email or a third-party via OAuth.